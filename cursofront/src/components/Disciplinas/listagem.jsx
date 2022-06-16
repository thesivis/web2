import { Table, Button } from 'react-bootstrap';
import React, { useState, useEffect } from 'react';
import { useRouter } from 'next/router';
import { Api } from '../../services/api';

export default function Disciplinas({ mostrar }) {
  const [disciplinas, setDisciplinas] = useState([]);
  const router = useRouter();
  const api = new Api('/api/disciplina');

  useEffect(() => listar(), []);

  const listar = () => {
    api.listar()
      .then(res => {
        setDisciplinas(res.data);
      })
      .catch(err => router.push('/login'));
  };

  const handleDelete = (id) => {
    if (confirm("Deseja remover a disciplina?")) {
      try {
        api.remover(id)
          .then( res => listar())
          .catch(err => alert(err));
      } catch (error) {
        alert(error);
      }
    }
  };

  return <Table striped bordered hover>
  <thead>
    <tr>
      <td>Id</td>
      <td>Nome</td>
      {mostrar && <td style={{ width: 200 }}>Ações</td>}
    </tr>
  </thead>
  <tbody>
    {disciplinas?.map((disc) => (
      <tr key={disc.id}>
        <td>{disc.id}</td>
        <td>{disc.nome}</td>
        {mostrar && <td><Button variant="info" href={"/disciplinas/" + disc.id}>Editar</Button><Button className="ml-2" onClick={() => handleDelete(disc.id)} variant="danger">Remover</Button></td>}
      </tr>
    ))
    }
  </tbody>
</Table>;
}

Disciplinas.defaultProps = {
mostrar: false
};