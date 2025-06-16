import axios from "axios";
import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { BASE_URL } from "../../config";
import { setLoading } from "../../redux/slices/loadingSlice";
import { Container, Col, Row } from "react-bootstrap";
import { setLibroStorage } from "../../redux/slices/libroData";
import { RiDeleteBin5Line } from "react-icons/ri";
import { MdOutlineEdit } from "react-icons/md";
import MenuBar from "../../components/MenuBar";

const LibrosSecreen = () => {
  const [libros, setLibros] = React.useState(null);
  const [eliminar, setEliminar] = React.useState(null);
  

  const libroState = useSelector((state) => state.libroData);
  const loading = useSelector((state) => state.loading.isLoading);

  const dispatch = useDispatch();

  React.useEffect(() => {
    getAllLibros();
  }, []);

  const getAllLibros = async () => {    
    try {
      const { data } = await axios({
        method: "GET",
        url: BASE_URL + "/libros/all",
        headers: {
          "Content-Type": "application/json",          
        },
      });      
      setLibros(data);      
      dispatch(setLibroStorage(data));
    } catch (error) {
      
      console.log("Se ha presentado un error ", error);
    }
  };

  const deleteId = async (id) => {
    var opcion = window.confirm(
      "Estás Seguro que deseas Eliminar el libro ISBN " + id
    );
    if (opcion == true) {
      try {
        axios.delete(`${BASE_URL}/libros/delete/${id}`

        ).then((response) => {
          setEliminar(response.data);
          getAllLibros();
        });
        
      } catch (error) {        
        console.log("Se ha presentado un error ", error);
      }
    }
  };

  return (
    <>
      {loading && "Cargando..."}
      {!loading && (
        <>
          <Row>
            <Col sm={2}>
              <div>
                <MenuBar></MenuBar>
              </div>
            </Col>
            <Col sm={10}>
              <div className="table table-responsive"></div>
              <table className="table table striped">
                <thead>
                  <tr>
                    <th>#</th>
                    <th>ID</th>
                    <th>ISBN</th>
                    <th>TITULO</th>
                    <th>AUTORES</th>
                    <th># EJEMPLARES</th>
                    <th>F. PUBLICACIÓN</th>
                    <th>EDITORIAL</th>
                    <th>ACCIONES</th>
                  </tr>
                </thead>
                <tbody>
                  {libros &&
                    libros.length > 0 &&
                    libros.map((data, index) => {
                      return (
                        <tr key={index}>
                          <td>{index}</td>
                          <td>{data.libroId}</td>
                          <td>{data.libroISBN}</td>
                          <td>{data.libroTitulo}</td>
                          <td>{data.libroAutores}</td>
                          <td>{data.libroEjemplares}</td>
                          <td>{data.libroPublicacion}</td>
                          <td>{data.libroEditorial}</td>
                          <td align="center">
                            <a className="btn btn-danger" onClick={()=> deleteId(data.libroISBN)}>
                              <RiDeleteBin5Line />
                            </a>
                            <a className="btn btn-success">
                              <MdOutlineEdit />
                            </a>
                          </td>
                        </tr>
                      );
                    })}
                </tbody>
              </table>
            </Col>
          </Row>
        </>
      )}
    </>
  );
};

export default LibrosSecreen;
