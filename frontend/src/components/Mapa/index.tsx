import React from "react";

const Mapa = () => {
  return (
    <main>
      <section className="container">
        <div className="contato">
          <p className="contato__titulo">Nosso estabelecimento</p>
          <p className="contato__subtitulo">
            Nosso estabelecimento esta localizado no coração da cidade.
          </p>
          <div className="contato__mapa--conteudo">
          <iframe
              src="https://www.google.com/maps/embed?pb=!1m26!1m12!1m3!1d15036.526181381092!2d-46.94813187079959!3d-19.57886423882087!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!4m11!3e6!4m3!3m2!1d-19.5685789!2d-46.9385294!4m5!1s0x94b03724089b7c65%3A0x7a88fcea268b41d4!2scred%20rapido%20araxa!3m2!1d-19.589166199999998!2d-46.9381278!5e0!3m2!1spt-BR!2sbr!4v1649300824251!5m2!1spt-BR!2sbr"
              width="100%"
              height="450"
              loading="lazy" title="Onde me encontrar"
            ></iframe>
          </div>
        </div>
      </section>
    </main>
  );
};

export default Mapa;
