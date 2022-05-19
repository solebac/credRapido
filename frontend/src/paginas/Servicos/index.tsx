import React from "react";
import Footer from "components/Footer";
import ComplementoServicos from "components/ListServices";
import Whatsapp from "components/Whatsapp";
import BannerServices from "components/BannerServices";
import ScrollToTop from "utils/ScrollToTop";

const Servicos = () => {
  return (
    <>
      <ScrollToTop />
      <BannerServices />
      <Whatsapp />
      <ComplementoServicos />
      <Footer />
    </>
  );
};
export default Servicos;
