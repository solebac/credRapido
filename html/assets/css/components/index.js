const botaoMenu = document.querySelector('.cabecalho__menu');
const menu = document.querySelector('.menu-lateral');
botaoMenu.addEventListener('click', ()=>{
    console.log(menu.classList);
    menu.classList.toggle('menu-lateral--ativo');
})