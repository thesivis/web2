import 'bootstrap/dist/css/bootstrap.min.css';
import { Container, Table } from 'react-bootstrap';
import React, { useState, useEffect } from 'react';
import { useRouter } from 'next/router';
import isAuthenticated from '../../services/isAuthenticated';
import axios from 'axios';
import headerAuthorization from '../../services/authHeaders';

export default function Disciplinas() {

  const [disciplinas, setDisciplinas] = useState([]);
  const [montar, setMontar] = useState(false);
  const router = useRouter();

  useEffect(
    () => {
      if (!isAuthenticated()) {
        router.push('/login');
      }
      setMontar(isAuthenticated());
    }
  );

  useEffect(
    () => {
      axios.get('http://localhost:8080/api/disciplina', {
        headers: headerAuthorization()
      }).then(res => {
        setDisciplinas(res.data);
      });
    }, []);

  return montar && <Container>
    <Table striped bordered hover>
      <thead>
        <tr>
          <td>Id</td>
          <td>Nome</td>
        </tr>
      </thead>
      <tbody>
        {disciplinas?.map((disc) => (
          <tr key={disc.id}>
            <td>{disc.id}</td>
            <td>{disc.nome}</td>
          </tr>
        )
        )
        }
      </tbody>
    </Table>
  </Container>;

}