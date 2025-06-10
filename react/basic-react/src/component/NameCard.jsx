import { useState } from "react";

const NameCardContent = ({ e }) => {
  return (
    <>
      <p>{e.name}</p>
      <p>{e.position}</p>
      <p>{e.company}</p>
      <p>{e.address}</p>
      <p>{e.email}</p>
      <p>{e.phone}</p>
    </>
  );
};

const NameCard = () => {
  const [nameCard, setNameCard] = useState({
    name: "",
    position: "",
    company: "",
    address: "",
    email: "",
    phone: "",
  });
  const [submit, setSubmit] = useState(false);
  const updateData = (key, value) => {
    setNameCard({ ...nameCard, [key]: value });
  };
  const uploadData = () => {
    setSubmit(true);
    console.log(submit);
    console.log(nameCard);
  };

  return (
    <>
      <input
        type="text"
        value={nameCard.name}
        placeholder="name"
        onChange={(e) => {
          updateData("name", e.target.value);
        }}
      />
      <br />
      <input
        type="text"
        value={nameCard.position}
        placeholder="position"
        onChange={(e) => {
          updateData("position", e.target.value);
        }}
      />
      <br />
      <input
        type="text"
        value={nameCard.company}
        placeholder="company"
        onChange={(e) => {
          updateData("company", e.target.value);
        }}
      />
      <br />
      <input
        type="text"
        value={nameCard.address}
        placeholder="address"
        onChange={(e) => {
          updateData("address", e.target.value);
        }}
      />
      <br />
      <input
        type="text"
        value={nameCard.email}
        placeholder="email"
        onChange={(e) => {
          updateData("email", e.target.value);
        }}
      />
      <br />
      <input
        type="text"
        value={nameCard.phone}
        placeholder="phone"
        onChange={(e) => {
          updateData("phone", e.target.value);
        }}
      />
      <br />
      <button onClick={uploadData}>제출</button>
      {submit && <NameCardContent e={nameCard}></NameCardContent>}
    </>
  );
};

export default NameCard;
