# language: pt

Funcionalidade: Propondo lances ao leilao

Cenario: Propondo um unico lance valido
	Dado um lance valido
	Quando propoe ao leilao
	Entao o lance eh aceito 
Cenario: Propondo varios lances validos
	Dado um lance de 10.0 reais do usuario "fulano"
	E um lance de 15.0 reais do usuario "beltrano"
	Quando propoe varios lances ao leilao
	Entao os lances sao aceitos
Cenario: Propondo um lance invalido
	Dado um lance de 0.0 reais
	Quando propoe o lance ao leilao
	Entao o lance nao e aceito