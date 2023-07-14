# language: pt

Funcionalidade: Propondo lances ao leilao

Cenario: Propondo um unico lance valido
	Dado um lance valido
	Quando propoe ao leilao
	Então o lance eh aceito 
Cenario: Propondo varios lances validos
	Dado varios lances validos
	Quando propoe varios lances ao leilao
	Então os lances sao aceitos