import { createSlice } from '@reduxjs/toolkit';



const libroDataSlice = createSlice({
    
 name: 'libroData',
 initialState: {
    libroId: null,
    libroISBN: null,
    libroTitulo:null,
    libroAutores: null,
    libroEjemplares:null,
    libroPublicacion:null,    
    libroEditorial:null,  
 },
 reducers: {
    setLibroStorage:(state, action)=>{                        
        return{
             ...state,
             libroId: action.payload?.libroId,  
             libroISBN: action.payload?.libroISBN,
             libroTitulo:action.payload?.libroTitulo,
             libroAutores: action.payload?.libroAutores,
             libroEjemplares:action.payload?.libroEjemplares,
             libroPublicacion:action.payload?.libroPublicacion,
             libroEditorial:action.payload?.libroEditorial,           
        }
    },
    setLogoutLibroStorage:(state, action)=>{
        return{
            ...state,
        }

    }
 }
});

export const { setLibroStorage, setLogoutLibroStorage} = libroDataSlice.actions;

export default libroDataSlice.reducer;