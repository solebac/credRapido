import React from "react";
import imgEmplooyes01 from '../../../assets/imagens/foot-leandro.png';
import imgEmplooyes02 from '../../../assets/imagens/foot-leandro-ping.png';

const Time = () => {
  return (
    <>
      <section className="container between">
        <p className="retrato__titulo retrato__titulo--sombra">Nosso time</p>
        <div className="retrato ceiling">
          <article className="retrato-card">
            <div className="retrato-item">
              <img
                className="retrato-img"
                src="https://www.placecage.com/280/240"
                alt=""
              />
              <p className="retrato-nome">Fulano Mala</p>
              <span className="retrato-span retrato-span--whatsapp">
                <i></i>(34) 987214577
              </span>
            </div>
          </article>

          <article className="retrato-card">
            <div className="retrato-item">
              <img
                className="retrato-img"
                src={imgEmplooyes01}
                alt=""
              />
              <p className="retrato-nome">Leandro Diretor</p>
              <span className="retrato-span retrato-span--whatsapp">
                <i></i>(34) 987214577
              </span>
            </div>
          </article>

          <article className="retrato-card">
            <div className="retrato-item">
              <img
                className="retrato-img"
                src={imgEmplooyes02}
                alt=""
              />
              <p className="retrato-nome">Flavio Rogerio</p>
              <span className="retrato-span retrato-span--whatsapp">
                <i></i>(34) 987214547
              </span>
            </div>
          </article>
        </div>
      </section>
    </>
  );
};

export default Time;