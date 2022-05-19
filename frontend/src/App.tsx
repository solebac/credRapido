import { BrowserRouter, Routes, Route } from "react-router-dom";
import Contato from "paginas/Contato";
import Sobre from "paginas/Sobre";
import Servicos from "paginas/Servicos";
import Home from "paginas/Home";
import Navbar from "components/Navbar";

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/sobre" element={<Sobre />} />
        <Route path="/contato" element={<Contato />} />
        <Route path="/servicos" element={<Servicos />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
