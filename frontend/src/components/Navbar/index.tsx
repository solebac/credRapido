import * as React from "react";
import { Link } from "react-router-dom";
import mainLogo from "assets/imagens/logo-white.png";
import "assets/css/util/base.css";
import "assets/css/components/cabecalho.css";

const Navbar = () => {
  return (
    <header>
      <nav className="cabecalho">
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
    </header>
  );
};
export default Navbar;
