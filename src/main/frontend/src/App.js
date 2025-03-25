import {useEffect, useState} from "react";
import axios from "axios";

function App() {
  const [hello, setHello] = useState('');

  useEffect(() => {
    axios.get('http://localhost:8080/test')
        .then((res) => {
          setHello(res.data);
        })
        .catch((error) => {
          console.error("에러 있는 부분: ", error);
        });
  }, []);
  return (
      <div className="App">
        백엔드 데이터 : {hello}
      </div>
  );
}

export default App;
