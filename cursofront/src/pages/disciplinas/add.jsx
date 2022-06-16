import Layout
  from "../../components/Layout/layout";
import FormDisciplina
  from "../../components/Disciplinas/formdisciplina";

export default function AddDisciplina(){

  return <Layout title={"Adicionar Disciplina"}>
    <FormDisciplina></FormDisciplina>
  </Layout>

}