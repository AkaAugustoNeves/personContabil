import { Routes } from '@angular/router';
import { BaseLayoutComponent } from './layouts/base-layout/base-layout.component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: 'lancamentos',
        pathMatch: 'full',
    },
    {
        path: '',
        component: BaseLayoutComponent,
        children: [
            {
                path: 'lancamentos',
                loadComponent: () => import('./tela/lancamentos/lancamentos.component').then(m => m.LancamentosComponent)
            },
            {
                path: 'teste',
                loadComponent: () => import('./tela/teste/teste.component').then(m => m.TesteComponent)
            }
        ]
    }
    
]; 
