import useGlobalErro from '../../context/erro/erro.context';
import { useState } from 'react';
import { depositoPassageiro } from '../../api/passageiro/deposito.api';
export function useDepositar(onError) {
  const [, setErro] = useGlobalErro();
  const [responseDepositar, setResponseDepositar] = useState(null);

  async function depositar(inputs, idMotorista) {
    try {
      const respostaApi = await depositoPassageiro(inputs, idMotorista);
      setResponseDepositar(respostaApi);
    } catch (error) {
      setErro(error.response.data.message || error.response.statusText);
      if (onError) {
        onError();
      }
    }
  }

  return { depositar, responseDepositar };
}
