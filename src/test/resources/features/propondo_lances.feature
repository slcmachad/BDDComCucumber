# language: pt

Funcionalidade: Propondo lances ao leilao

Esquema do Cenario: Propondo um unico lance valido
	Dado um lance valido
	Quando propoe ao leilao
	Entao o lance eh aceito 
Esquema do Cenario: Propondo varios lances validos
	Dado um lance de 10.0 reais do usuario "fulano"
	E um lance de 15.0 reais do usuario "beltrano"
	Quando propoe varios lances ao leilao
	Entao os lances sao aceitos
Esquema do Cenario: Propondo um lance invalido
	Dado um lance invalido de <valor> reais
	Quando propoe o lance ao leilao
	Entao o lance nao e aceito

Exemplos:
	| valor | 
	|0			|
	|-1			|