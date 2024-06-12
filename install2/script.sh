#!/bin/bash

sudo apt-get install -y openjdk-17-jre-headless

echo "Instalando Docker..."


sudo apt-get install -m 0755 -d /etc/apt/keyrings/docker.asc
curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc
sudo apt upgrade
sudo apt-get install docker-ce docker-ce-cli containerd.io

echo "tudo ok :)"