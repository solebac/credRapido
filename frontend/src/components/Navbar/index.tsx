import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import mainLogo from "assets/imagens/logo-white.png";
import "assets/css/util/base.css";
import "assets/css/components/cabecalho.css";
import imgsap from "assets/imagens/whatsapp.png";

const Navbar = () => {
  const [isOpen, setOpen] = useState(false);
  function hasToggle() {
    const menu = document.querySelector(".menu-lateral");
    menu?.classList.toggle("menu-lateral--ativo");
  }
  useEffect(() => {
    if (isOpen) {
      hasToggle();
    }
  }, [isOpen]);

  const handleClick = (event: any) => {
    event.preventDefault();
    hasToggle();
    setOpen(false);
  };
  return (
    <header>
      <nav className="cabecalho">
        <button
          className="cabecalho__menu"
          aria-label="Menu"
          onClick={handleClick}
        >
          <i></i>
        </button>
        <img className="cabecalho__logo-principal" src={mainLogo} alt="" />
        <ul className="cabecalho__itens">
          <li className="cabecalho__itens--subItens">
            <Link className="cabecalho__subItens-link" to="/">
              Home
            </Link>
          </li>
          <li className="cabecalho__itens--subItens">
            <Link className="cabecalho__subItens-link" to="/servicos">
              Seviços
            </Link>
          </li>
          <li className="cabecalho__itens--subItens">
            <Link className="cabecalho__subItens-link" to="/sobre">
              Sobre
            </Link>
          </li>
          <li className="cabecalho__itens--subItens">
            <Link className="cabecalho__subItens-link" to="/contato">
              Contato
            </Link>
          </li>
        </ul>
      </nav>
      <div className="menu-lateral">
        <img
          className="cabecalho__logo-principal menu-lateral--icon"
          src={mainLogo}
          alt="Menu Financeira"
        />
        <Link
          className="menu-lateral__link menu-lateral__link--home menu-lateral__link--ativo"
          to="/"
          onClick={() => {
            setOpen(true);
          }}
        >
          Home
        </Link>

        <Link
          className="menu-lateral__link menu-lateral__link--home menu-lateral__link--service"
          to="/servicos"
          onClick={() => {
            setOpen(true);
          }}
        >
          Seviços
        </Link>

        <Link
          className="menu-lateral__link menu-lateral__link--home menu-lateral__link--about"
          to="/sobre"
          onClick={() => {
            setOpen(true);
          }}
        >
          Sobre
        </Link>

        <Link
          className="menu-lateral__link menu-lateral__link--home menu-lateral__link--contact"
          to="/contato"
          onClick={() => {
            setOpen(true);
          }}
        >
          Contato
        </Link>
        <a
          href="http://api.whatsapp.com/send?1=pt_BR&amp;phone=5534988613813"
          className="menu-lateral--redirect"
        >
          <img
            className="menu-lateral--whatsapp"
            src={imgsap}
            alt="Atendimento personalizado...!"
          />
        </a>
      </div>
    </header>
  );
};
export default Navbar;
