##Primeira implementação: https://github.com/caieradev/T1ALEST2/tree/15ea13bebd3dcd44392fccf3ec3a3af038f73fec

Para cada rodada, executar as seguintes ações em cada macaco

separar os cocos com numero par de pedrinhas em uma coleção de cocos pares

separar os cocos com numero impar de pedrinhas em uma coleção de cocos impares

zerar a coleção de cocos do macaco

buscar o macaco que deve receber os cocos pares

adicionar a coleção de cocos do macaco encontrado os cocos pares

buscar o macaco que deve receber os cocos impares

adicionar a coleção de cocos do macaco encontrado os cocos impares

apos fazer todas as rodadas, procurar o macaco com o maior numero de cocos

##Segunda implementação: https://github.com/caieradev/T1ALEST2/tree/283ad7062f45543311f2a62a5805006226186d0b

Após realizar a leitura de uma linha do arquivo, agora separar os cocos pares e impares em uma coleção própria para cada um na Entidade

Agora, em cada rodada, para cada macaco:
    buscar o macaco que deve receber os cocos impares e adicionar a sua coleção de impares, os cocos impares do macaco que esta sendo analisado

    buscar o macaco que deve receber os cocos pares e adicionar a sua coleção de pares, os cocos pares do macaco que esta sendo analisado

    remover todos os cocos do macaco

##Terceira implementação: https://github.com/caieradev/T1ALEST2/tree/20fcd3ef8ee25409cac8812d2031e6a918a0251c

Mesmo algorítimo, porém sua implementação foi feita utilizando outra estrutura de dados

##Quarta implementação: https://github.com/caieradev/T1ALEST2/tree/04326392cabaac743767ee18a12aa8a322d7b203

Após a leitura do arquivo inteiro:
    criar uma coleção contendo os macacos e os macacos receptores de cocos pares

    criar uma coleção contendo os macacos e os macacos receptores de cocos impares

Durante a execução do jogo:
    Ao invés de buscar no macaco os seus receptores, utilizar a coleção

##Quinta implementação: https://github.com/caieradev/T1ALEST2/tree/47b260019df85c8e57dd5269726c7bacf40098f2

Durante das linhas do arquivo:
    Agora, ao inves de adicionar os cocos a uma coleção, é somente adicionado o número de cocos pares ou impares a Entidade

Durante a execução do jogo:
    Ao invés de buscar a coleção de cocos pares, agora pegamos somente o número que representa a quantidade de cocos pares
    Busca-se o macaco que deve receber os cocos pares
    Soma a quantidade de cocos pares a quantidade de cocos pares do macaco receptor

    Ao invés de buscar a coleção de cocos impares, agora pegamos somente o número que representa a quantidade de cocos impares
    Busca-se o macaco que deve receber os cocos impares
    Soma a quantidade de cocos impares a quantidade de cocos impares do macaco receptor
    
    Ao invés de zerar a coleção de cocos pares ou impares, somente zeramos a quantidade