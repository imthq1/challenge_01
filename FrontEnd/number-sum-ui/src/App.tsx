import { useState } from "react";
import "./App.css";
import BigNumberSum from "./BigNumberSum";

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <BigNumberSum />
    </>
  );
}

export default App;
