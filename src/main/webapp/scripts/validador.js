/**
* 
*/
function validar() {
	let nome = formBanda.nome.value
	let genero = formBanda.genero.value

	if (nome === "") {
		alert('Preencha o nome da banda')
		formBanda.nome.focus()
		return false
	} else if (genero === "") {
		alert('Preencha o gênero da banda')
		formBanda.genero.focus()
		return false
	} else {
		document.forms["formBanda"].submit()
	}
}