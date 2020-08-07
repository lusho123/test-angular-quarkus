import { Component, OnInit } from '@angular/core';
import { NbDialogService, NbToastrService } from '@nebular/theme';
import { UserVO } from '../../../shared/model/User';
import { UserService } from '../../../shared/services/user.service';
import { LocalDataSource } from 'ng2-smart-table';
import { SmartTableData } from '../../../@core/data/smart-table';
import { EditUserComponent } from '../edit-user/edit-user.component';

@Component({
  selector: 'ngx-show-users',
  templateUrl: './show-users.component.html',
  styleUrls: ['./show-users.component.scss']
})
export class ShowUsersComponent implements OnInit {

  public users: UserVO[];
  public id: string;

  constructor(private api: UserService, 
              private dialogService: NbDialogService, 
              private toastrService: NbToastrService,
              private service: SmartTableData) {  }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers() {
    this.api.getUsers().subscribe(
      response => {
        this.users = response.data,
        this.source.load(this.users);
      },
      error =>  console.log(error)
    );
  }

  openModal(event: any) {
    this.dialogService.open(EditUserComponent, {
      context: {
        id: event.data.id
      }
    }).onClose.subscribe(
      data => {
        if (!data) return;
        if (data.delId) this.deleteFromUsers(data.id);
        else this.updateUser(data);
      }
    );
  }

  deleteFromUsers(id: string) {
    this.users.filter((user, index) => {
      if(user.id === id){
        console.log(user);
        this.users.splice(index, 1);
      }
    });
    this.source.load(this.users);
  }

  updateUser(user: UserVO) {
    this.users.forEach((find,index, users) => {
      if (find.id === user.id) users[index] = user;
    });
    this.source.load(this.users);
  }


  showToast(position, status, message, title) {
    this.toastrService.show(
      message,
      title,
      { position, status });
  }

  settings = {
    hideSubHeader: true,
    actions: {
      columnTitle: 'Acciones',
      add: false,
      edit: false,
      delete: false, 
      custom: [
        {
          name: 'customEdit',
          title: '<i class="nb-edit edit"></i>',
          // title: 'Editar',
          type: 'custom',
          width: '5%'
        }
      ],
      // position: 'right'
    },
    // add: {
    //   addButtonContent: '<i class="nb-plus"></i>',
    //   createButtonContent: '<i class="nb-checkmark"></i>',
    //   cancelButtonContent: '<i class="nb-close"></i>',
    // },
    // edit: {
    //   editButtonContent: '<i class="nb-edit"></i>',
    //   saveButtonContent: '<i class="nb-checkmark"></i>',
    //   cancelButtonContent: '<i class="nb-close"></i>',
    // },
    // delete: {
    //   deleteButtonContent: '<i class="nb-trash"></i>',
    //   confirmDelete: true,
    // },
    columns: {
      name: {
        title: 'Nombre',
        type: 'string',
      },
      firstLastName: {
        title: 'Apellido Paterno',
        type: 'string',
      },
      secondLastName: {
        title: 'Apellido Materno',
        type: 'string',
      },
      user: {
        title: 'Usuario',
        type: 'string'
      },
      email: {
        title: 'E-mail',
        type: 'string',
      },
      phone: {
        title: 'Telefono',
        type: 'string',
      },
    },
  };

  source: LocalDataSource = new LocalDataSource();

  onDeleteConfirm(event): void {
    if (window.confirm('Are you sure you want to delete?')) {
      event.confirm.resolve();
    } else {
      event.confirm.reject();
    }
  }

}
