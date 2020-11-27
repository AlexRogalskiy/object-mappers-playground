#!/usr/bin/env bash

# Small variable to determine exit code at the end
ERRORS=0
IMAGES=0

# Small error handling method, that works with GitHub Actions
function error() {
  local file=${1}
  local message=${2}
  ((ERRORS++))

  if [[ ! -z "${GITHUB_ACTIONS}" ]]; then
    echo "::error file=${file}::${message}: ${file}"
  else
    echo "${message}: ${file}"
  fi
}

# Find all files in the src folder (should contain only images)
while read image; do
  # Read properties from image
  properties=($(identify -format "%w %h %m" "${image}"))
  if [[ "$?" -ne 0 ]]; then
    error "${image}" "Could not read image file"
    continue
  fi

  # Extract properties into variables
  filename=$(basename "${image}")
  folderpath=$(dirname "${image}")
  foldername=$(basename "${folderpath}")
  width="${properties[0]}"
  height="${properties[1]}"
  type="${properties[2]}"

  # Underscore folders are special cases. Instead one should symlink between integration domains
  [[ "${foldername}" == _* && "${foldername}" != "_default" ]] &&
    error "${folderpath}" "Directories should not start with an underscore (_), please use the integration domain instead"

  # Ensure file is actually a PNG/ICON file
  [[ "${type}" != "PNG" || "${type}" != "ICON" ]] &&
    error "${image}" "Invalid file type '${type}' for file"

  # Validate image dimensions
  if [[ "${filename}" =~ .*\-(32|64)\.(icon) ]]; then
    # icon dimension
    [[ "${width}" -ne 64 || "${height}" -ne 64 ]] &&
      error "${image}" "Invalid icon size! Size is ${width}x${height}px, must be 256x256px"

  elif [[ "${filename}" =~ .*\-(128|256|512)\.(icon) ]]; then
    # hDPI icon dimension
    [[ "${width}" -ne 512 || "${height}" -ne 512 ]] &&
      error "${image}" "Invalid hDPI icon size! Size is ${width}x${height}px, must be 512x512px"

  elif [[ "${filename}" =~ .*\-(32|64|128|256)\.(png) ]]; then
    # Minimal shortest side
    if [[ "${width}" -le "${height}" && "${width}" -lt 32 ]]; then
      error "${image}" "Invalid logo size! Size is ${width}x${height}px, shortest side must be at least 32px"
    elif [[ "${width}" -ge "${height}" && "${height}" -lt 32 ]]; then
      error "${image}" "Invalid logo size! Size is ${width}x${height}px, shortest side must be at least 32px"
    fi

    # Maximal shortest size
    if [[ "${width}" -le "${height}" && "${width}" -gt 256 ]]; then
      error "${image}" "Invalid logo size! Size is ${width}x${height}px, shortest side must not exceed 256px"
    elif [[ "${width}" -ge "${height}" && "${height}" -gt 256 ]]; then
      error "${image}" "Invalid logo size! Size is ${width}x${height}px, shortest side must not exceed 256px"
    fi

  elif [[ "${filename}" =~ .*\-(256|512)\.(png) ]]; then
    # Minimal shortest side
    if [[ "${width}" -le "${height}" && "${width}" -lt 256 ]]; then
      error "${image}" "Invalid hDPI logo size! Size is ${width}x${height}px, shortest side must be at least 256px"
    elif [[ "${width}" -ge "${height}" && "${height}" -lt 256 ]]; then
      error "${image}" "Invalid hDPI logo size! Size is ${width}x${height}px, shortest side must be at least 256px"
    fi

    # Maximal shortest side
    if [[ "${width}" -le "${height}" && "${width}" -gt 512 ]]; then
      error "${image}" "Invalid hDPI logo size! Size is ${width}x${height}px, shortest side must not exceed 512px"
    elif [[ "${width}" -ge "${height}" && "${height}" -gt 512 ]]; then
      error "${image}" "Invalid hDPI logo size! Size is ${width}x${height}px, shortest side must not exceed 512px"
    fi

  else
    # Unexpected file
    error "${image}" "Unknown and invalid filename"
  fi

  ((IMAGES++))
done <<<$(find docs/images -type f)

echo "\nTotal of ${IMAGES} images checked, found ${ERRORS} issues.\n"

[[ "${ERRORS}" -ne 0 ]] && exit 1 || exit 0
