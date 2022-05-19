import React, { Fragment } from "react";
import '../../../assets/css/components/retrato.css';

const Categorias = () => {
  return (
    <Fragment>
      <section className="container between">
        <p className="retrato__titulo retrato__titulo--sombra">Categorias</p>

        <article className="container">
          <div className="destaque">
            <p className="destaque__titulo">
              Venha para cá na certeza do melhor atendimento
            </p>
            <p className="destaque__subTitulo">Atendemos você</p>
            <ul className="destaque__lista">
              <li className="destaque__itens">Aposentado e pensionista</li>
              <li className="destaque__itens">
                Funcionários públicos federais, estaduais e municipais
              </li>
              <li className="destaque__itens">
                Funcionarios registrados em regime CLT
              </li>
              <li className="destaque__itens">
                Autônomos com bom histórico financeiro
              </li>
              <li className="destaque__itens">Comodidade e conforto</li>
              <li className="destaque__itens">Microempreendedores individuais</li>
            </ul>
          </div>
        </article>
      </section>
    </Fragment>
  );
};

export default Categorias;
