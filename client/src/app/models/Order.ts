import { Article } from "./Article";

export class Order{


    constructor(
        public id:number
        ,public ref:string
        ,public date:Date
        ,public articles:Article[]
    ){}
}