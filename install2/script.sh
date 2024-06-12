#!/bin/bash

# Este script instala o OpenJDK 17 JRE Headless e o Docker.

# Função para imprimir uma mensagem de erro e sair
function error_exit {
    echo "$1" 1>&2
    exit 1
}

# Atualiza a lista de pacotes e instala as dependências para adicionar novos repositórios
echo "Atualizando a lista de pacotes..."
sudo apt-get update || error_exit "Falha ao atualizar a lista de pacotes."

# Instala OpenJDK 17 JRE Headless
echo "Instalando OpenJDK 17 JRE Headless..."
sudo apt-get install -y openjdk-17-jre-headless || error_exit "Falha ao instalar o OpenJDK 17 JRE Headless."

# Verifica a instalação do OpenJDK
echo "Verificando a instalação do OpenJDK..."
java -version || error_exit "Falha ao verificar a instalação do OpenJDK."

# Adiciona o repositório oficial do Docker
echo "Adicionando o repositório oficial do Docker..."
sudo apt-get install -y \
    apt-transport-https \
    ca-certificates \
    curl \
    software-properties-common || error_exit "Falha ao instalar dependências do Docker."

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg || error_exit "Falha ao adicionar a chave GPG do Docker."

echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null || error_exit "Falha ao adicionar o repositório do Docker."

# Atualiza a lista de pacotes novamente para incluir o repositório do Docker
echo "Atualizando a lista de pacotes para incluir o repositório do Docker..."
sudo apt-get update || error_exit "Falha ao atualizar a lista de pacotes com o repositório do Docker."

# Instala Docker
echo "Instalando Docker..."
sudo apt-get install -y docker-ce docker-ce-cli containerd.io || error_exit "Falha ao instalar o Docker."

# Verifica a instalação do Docker
echo "Verificando a instalação do Docker..."
sudo docker --version || error_exit "Falha ao verificar a instalação do Docker."

# Adiciona o usuário atual ao grupo docker para executar comandos Docker sem sudo (necessário logout/login para efeito)
echo "Adicionando o usuário atual ao grupo docker..."
sudo usermod -aG docker $USER || error_exit "Falha ao adicionar o usuário ao grupo docker."

echo "Instalação concluída com sucesso. Por favor, faça logout e login novamente para aplicar as mudanças de permissões do Docker."
