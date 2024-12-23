import { axiosInstance } from '../_base/axios-instance';

const URL_PEDIR_CORRIDA = '/passageiros';

export async function pedirCorrida(inputs, idPassageiro) {
  const resposta = await axiosInstance.post(
    URL_PEDIR_CORRIDA + `/${idPassageiro}` + '/solicitar-corrida',
    {
      inicioX: inputs.latitudeInicio,
      inicioY: inputs.longitudeInicio,
      finalX: inputs.latitudeFinal,
      finalY: inputs.longitudeFinal,
    }
  );
  return resposta.data;
}
