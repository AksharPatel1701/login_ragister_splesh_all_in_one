package com.example.splashscreen

data class Sup (var sup_username:String,var sup_pass:String)
{
    var sup_name:String=""
    var sup_emil:String=""
    var sup_numb:Long=0
    constructor(sup_name:String,sup_username:String,sup_pass:String,sup_emil:String,sup_numb:Long):this(sup_username,sup_pass)
    {
        this.sup_name=sup_name
        this.sup_emil=sup_emil
        this.sup_numb=sup_numb
    }
}