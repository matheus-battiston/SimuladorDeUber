import './mapa.css';

export function Mapa({
  titulo,
  latitudeInicio,
  longitudeInicio,
  latitudeFim,
  longitudeFim,
}) {
  return (
    <div className="mapa-component">
      <h1>{titulo}</h1>
      <iframe
        title="mapa"
        src={`https://www.google.com/maps/embed/v1/directions?key=AIzaSyA0Ify5MilQWsZ9mLBW2u6ZnuKkyq0f0HM&origin=${latitudeInicio},${longitudeInicio}&destination=${latitudeFim},${longitudeFim}&mode=driving`}
      ></iframe>
    </div>
  );
}
