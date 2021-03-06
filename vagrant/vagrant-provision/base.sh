#!/usr/bin/env bash

apt-get update
curl -sL https://deb.nodesource.com/setup_8.x | sudo -E bash -
apt-get install -y git vim build-essential htop nodejs ufw nginx curl tree dirmngr
npm i -g pm2
ufw allow 'Nginx HTTP'
ufw allow 'OpenSSH'
ufw allow 5432 # Postgres
yes | ufw enable
