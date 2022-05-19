import * as React from "react";
import imgsap from "assets/imagens/whatsapp.png";
const Whatsapp = () => {
  return (
    <div>
      <a href="http://api.whatsapp.com/send?1=pt_BR&amp;phone=5534988613813">
      <img className="call" src={imgsap} alt="Atendimento personalizado...!" />
      </a>
    </div>
  );
};
export default Whatsapp;
