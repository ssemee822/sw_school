// 실제 돔을 제어하기 위해서 사용되는 useRef

import { useRef } from "react";

function CreateRef() {
  const inputRef = useRef(null);

  const handleFocus = () => {
    inputRef.current.disabled = false;
    inputRef.current.focus();
  };

  return (
    <>
      <input disabled type="text" ref={inputRef} />
      <button onClick={handleFocus}>활성화</button>
    </>
  );
}

export default CreateRef;
