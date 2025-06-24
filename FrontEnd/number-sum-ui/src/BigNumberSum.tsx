// BigNumberSum.tsx
import React, { useState } from "react";
import "./BigNumberSum.css";

interface Step {
  stepNumber: number;
  digit1: number;
  digit2: number;
  resultDigit: number;
  carry: number;
}

interface SumResponse {
  result: string;
  steps: Step[];
}

const BigNumberSum: React.FC = () => {
  const [number1, setNumber1] = useState("");
  const [number2, setNumber2] = useState("");
  const [result, setResult] = useState("");
  const [steps, setSteps] = useState<Step[]>([]);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/api/v1/sum", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ number1, number2 }),
      });

      if (!response.ok) throw new Error("Lỗi mạng");

      const data: SumResponse = await response.json();
      setResult(data.result);
      setSteps(data.steps);
    } catch (error) {
      console.error("Lỗi khi gọi API:", error);
    }
  };

  return (
    <div className="max-w-2xl mx-auto p-4">
      <h1 className="text-2xl font-bold mb-4">Cộng 2 số lớn</h1>
      <form onSubmit={handleSubmit} className="space-y-4">
        <input
          type="text"
          placeholder="Số thứ nhất"
          value={number1}
          onChange={(e) => setNumber1(e.target.value)}
          className="border p-2 w-full"
          required
        />
        <input
          type="text"
          placeholder="Số thứ hai"
          value={number2}
          onChange={(e) => setNumber2(e.target.value)}
          className="border p-2 w-full"
          required
        />
        <button
          type="submit"
          className="bg-blue-500 text-white px-4 py-2 rounded"
        >
          Tính toán
        </button>
      </form>

      {result && (
        <div className="mt-6">
          <h2 className="text-xl font-semibold mb-2">Kết quả: {result}</h2>
          <table className="w-full border text-left">
            <thead>
              <tr className="bg-gray-100">
                <th className="border p-2">Bước</th>
                <th className="border p-2">Số 1</th>
                <th className="border p-2">Số 2</th>
                <th className="border p-2">Kết quả</th>
                <th className="border p-2">Nhớ</th>
              </tr>
            </thead>
            <tbody>
              {steps.map((step) => (
                <tr key={step.stepNumber}>
                  <td className="border p-2">{step.stepNumber}</td>
                  <td className="border p-2">{step.digit1}</td>
                  <td className="border p-2">{step.digit2}</td>
                  <td className="border p-2">{step.resultDigit}</td>
                  <td className="border p-2">{step.carry}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default BigNumberSum;
