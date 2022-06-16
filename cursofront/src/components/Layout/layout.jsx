import 'bootstrap/dist/css/bootstrap.min.css';
import { useRouter } from "next/router";
import { useEffect, useState } from "react";
import isAuthenticated from '../../services/isAuthenticated';
import TopBar from "../TopBar/topbar";
import Footer from "../Footer/footer";
import { Container } from 'react-bootstrap';

export default function Layout({title,children}) {

  const [montar, setMontar] = useState(false);
  const router = useRouter();

  useEffect(() => {
    var auth = isAuthenticated();
    if (!auth) {
      router.push('/login');
    }
    setMontar(auth);
  });

  
  return (montar && 
    <Container>
      <TopBar></TopBar>
      <fieldset className="border p-2"><legend className="w-auto">{title}</legend>
        {children}
      </fieldset>
      <Footer></Footer>
    </Container>
  );

}

Layout.defaultProps = {
  title: "Home",
};