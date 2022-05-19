import React from "react";
import { Servicos } from "types/financeiro";

type Props = {
  services: Servicos;
};

const ServicosCard = ({ services }: Props) => {
  return (
    <>
      <p className="retrato__titulo retrato__titulo--sombra">
        {services.titulo}
      </p>
      <div className="retrato ceiling servicos_card">
        <p className="contato__subtitulo">{services.descricao}</p>
      </div>
    </>
  );
};
export default ServicosCard;
