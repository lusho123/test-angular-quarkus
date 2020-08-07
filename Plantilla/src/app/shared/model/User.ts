export interface User {

    id: any;
    user: string;
    name: string;
    firstLastName: string;
    secondLastName: string;
    password: String;
    idProfile: any;
    idStatus: number;
    email: string;
    phone: string;

}

export interface UserVO {

    id: any;
    user: string;
    name: string;
    firstLastName: string;
    secondLastName: string;
    profile: Profile;
    email: string;
    phone: string;

}

export interface Profile {

    id: any;
    name: string;
    types: Type[];

}

export interface Type {

    id: any;
    name: string;
    description: string;
    device: string;

}