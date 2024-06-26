#!/bin/bash

yes | sudo adduser cliente_medtech

echo "cliente_medtech:medtech123" | sudo chpasswd


# Atualizar
echo "\n\nATUALIZANDO O SISTEMA\n\n"
#yes | sudo apt update
#yes | sudo apt upgrade

# JDK
java --version

if [ $? = 0 ]
        then
                echo "\n\nJAVA JÁ ESTÁ INSTALADO\n\n"
        else
                echo "\n\nJAVA NÃO ENCONTRADO! INSTALANDO...\n\n"
                yes | sudo apt install openjdk-17-jre-headless
fi

# GitHub
sudo chmod 111 script.sh
sudo chmod 111 ../cliente_medtech/medtech

# MYSQL
echo "\n\nCONFIGURANDO BANCO DE DADOS\n\n"

yes | sudo apt install mysql-server
yes | sudo systemctl start mysql
yes | sudo systemctl enable mysql

SQL_SCRIPT="script.sql"

sudo mysql < "$SQL_SCRIPT"

echo "\n\nTUDO CONFIGURADO! EXECUTE OS SEGUINTES COMANDOS PARA RODAR A APLICAÇÃO /n :1- java -jar appCliente.jar"
sudo su cliente_medtech