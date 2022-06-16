import { useRouter } from "next/router";
import Layout
  from "../../components/Layout/layout";
import FormDisciplina
  from "../../components/Disciplinas/formdisciplina";

export default function EditDisciplina(){

  const router = useRouter();
  const { id } = router.query;

  return <Layout title={"Editar Disciplina"}>
    <FormDisciplina id={id}></FormDisciplina>
  </Layout>

}