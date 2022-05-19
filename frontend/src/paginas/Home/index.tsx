import BannerHome from "components/BannerHome";
import Footer from "components/Footer";
import Main from "components/Main";
import Whatsapp from "components/Whatsapp";
import React from "react";
import ScrollToTop from "utils/ScrollToTop";

const Home = () => {
  return (
    <>
      <ScrollToTop />
      <BannerHome />
      <Whatsapp />
      <Main />
      <Footer />
    </>
  );
};
export default Home;
