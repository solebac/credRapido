import React from "react";
import "assets/css/components/rodape.css";
import imgOferta from "assets/imagens/oferta.png";
import imgLogo from "assets/imagens/logo-white.png";
import { ReactComponent as SvgFacebook } from "assets/icones/facebook.svg";
import { ReactComponent as SvgInstagram } from "assets/icones/instagram.svg";
import { ReactComponent as SvgTwitter } from "assets/icones/twitter.svg";
import { Link } from "react-router-dom";

const Footer = () => {
  return (
    <footer>
      <section className="rodape">
        <div className="rodape__fluid">
          <div className="coluna">
            <Link className="rodape__item--texto" to="/">
              <img
                className="cabecalho__logo-principal"
                src={imgLogo}
                alt="Início"
              />
            </Link>
            <hr className="rodape_regua" />
            <p className="rodape__pensamento">
              Não case por dinheiro... Você pode conseguir empréstimos com taxas
              menores...
            </p>
          </div>

          <div className="coluna">
            <p className="rodape__titulo">Acesso Rápido</p>
            <ul className="rodape__lista-item">
              <li className="rodape__item">
                <Link className="rodape__item--texto" to="/servicos">
                  Empréstimo
                </Link>
              </li>
              <li className="rodape__item">
                <Link className="rodape__item--texto" to="/servicos">
                  Refinanciamento
                </Link>
              </li>
              <li className="rodape__item">
                <Link className="rodape__item--texto" to="/servicos">
                  Portabilidade
                </Link>
              </li>
              <li className="rodape__item">
                <Link className="rodape__item--texto" to="/servicos">
                  Dinheiro
                </Link>
              </li>
            </ul>
          </div>

          <div className="coluna">
            <p className="rodape__titulo">Conecte-se</p>
            <p className="rodape__item--redes">Nossas redes socíais</p>
            <ul className="rodape__redes">
              <li>
                <a
                  href="https://www.facebook.com/casadacrianca.araxamg/"
                  className="rodape__social-midia"
                  target="_blank" rel="noopener noreferrer"
                >
                  <SvgFacebook />
                </a>
              </li>
              <li>
                <a
                  href="https://www.instagram.com/accounts/login/?next=/casadacriancaaraxa/"
                  className="rodape__social-midia"
                  target="_blank" rel="noopener noreferrer"
                >
                  <SvgInstagram />
                </a>
              </li>
              <li>
                <a
                  href="https://twitter.com/home"
                  className="rodape__social-midia"
                  target="_blank" rel="noopener noreferrer"
                >
                  <SvgTwitter />
                </a>
              </li>
            </ul>
          </div>

          <div className="coluna">
            <h1 className="center">
              <img
                className="rodape_oferta"
                src={imgOferta}
                alt="Cobrimos qualquer oferta"
              />
            </h1>
          </div>
        </div>
        <address className="copyright">
          <span>
            R. Padre Anchieta, Numero 98 - Centro, Araxá - MG, 38183-084
          </span>
          <br />
          Telefone: (11) 00000-0000 <br />
        </address>
        <p className="copyright">© Copyright CredRápido - 2022</p>
      </section>
    </footer>
  );
};

export default Footer;
