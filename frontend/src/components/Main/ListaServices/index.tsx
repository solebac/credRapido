import React from "react";
import "../../../assets/css/components/item.css";
import { Link } from "react-router-dom";

const ListaServices = () => {
  return (
    <>
      <section className="container between">
        <ul className="lista-item">
          <li className="item">
            <Link className="item--texto" to="/servicos">
              Empréstimo
            </Link>
          </li>
          <li className="item">
            <Link className="item--texto" to="/servicos">
              Refinanciamento
            </Link>
          </li>
          <li className="item">
            <Link className="item--texto" to="/servicos">
              Portabilidade
            </Link>
          </li>
          <li className="item">
            <Link className="item--texto" to="/servicos">
              Dinheiro
            </Link>
          </li>
        </ul>
      </section>
    </>
  );
};

export default ListaServices;
