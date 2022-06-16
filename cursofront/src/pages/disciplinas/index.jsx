import { Button, Row } from 'react-bootstrap';
import Layout 
  from '../../components/Layout/layout';
import Disciplinas 
  from '../../components/Disciplinas/listagem';

export default function DisciplinasIndex() {
  
  return <Layout title="Disciplinas">
    <Row className="float-right row pb-2 pr-5">
      <Button variant="primary" href="/disciplinas/add">+ Adicionar</Button>
    </Row>
    <Disciplinas mostrar={true}></Disciplinas>
  </Layout>;
}