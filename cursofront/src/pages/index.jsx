import 'bootstrap/dist/css/bootstrap.min.css';
import { useRouter } from 'next/router';
import { useEffect, useState } from 'react';
import isAuthenticated from '../services/isAuthenticated';
export default function Home() {

  const router = useRouter();
  const [montar, setMontar] = useState(false);

  useEffect(
    () => {
      if(!isAuthenticated()){
        router.push('/login');
      }
      setMontar(isAuthenticated());
    }
  );
  return montar && <div>Curso WEB!</div>
}