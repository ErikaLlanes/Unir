import { createSlice } from '@reduxjs/toolkit';



const usuarioDataSlice = createSlice({
    
 name: 'usuarioData',
 initialState: {
    usuarioCedula: null,
    usuarioNombre: null,
    usuarioApellido: null,
    usuarioCelular: null,
    usuarioDireccion: null
 },
 reducers: {
    setUsuarioStorage:(state, action)=>{                   
        return{
             ...state,
             usuarioCedula: action.payload?.usuarioCedula,  
             usuarioNombre: action.payload?. usuarioNombre,
             usuarioApellido:action.payload?.usuarioApellido,
             usuarioCelular: action.payload?.usuarioCelular,
             usuarioDireccion:action.payload?.usuarioDireccion                       
        }
    },
    setLogoutUsuarioStorage:(state, action)=>{
        return{
            ...state,
        }

    }
 }
});

export const { setUsuarioStorage, setLogoutUsuarioStorage} = usuarioDataSlice.actions;

export default usuarioDataSlice.reducer;