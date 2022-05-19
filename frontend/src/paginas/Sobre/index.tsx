import ComplementoSobre from "components/ComplementoSobre";
import Footer from "components/Footer";
import "../../assets/css/servicos/servicos.css";

import React from "react";
import Whatsapp from "components/Whatsapp";
import BannerSobre from "components/BannerSobre";
import ScrollToTop from "utils/ScrollToTop";

const Sobre = () => {
  return (
    <>
      <BannerSobre />
      <ScrollToTop />
      <Whatsapp />
      <ComplementoSobre />
      <Footer />
    </>
  );
};
export default Sobre;
