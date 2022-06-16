import { useRouter } from "next/router";
import { Navbar, Nav} from 'react-bootstrap';
import { useEffect, useState } from "react";
import isAuthenticated from '../../services/isAuthenticated';

export default function TopBar() {
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
    <Navbar bg="light" expand="lg">
      <Navbar.Brand href="/">Escola</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="me-auto">
          <Nav.Link href="/disciplinas">Disciplinas</Nav.Link>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
    );
}