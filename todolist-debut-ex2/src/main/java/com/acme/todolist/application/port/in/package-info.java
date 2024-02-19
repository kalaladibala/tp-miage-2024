/**
 * Contient les fonctions d'expose le domaine aux adapteurs
 * 
 * Les adapteurs pourraient appeler directemeznt le doamine tout en respectant le principe d'inversion de dépendance (SOLI_D_) 
 * mais le fait d'utiliser des ports 'in' permet de limiter la surface exposée et de clairement isoler chaque fonction exposée 
 * (c'est le principe SOL_I_D) de la segregation d'interfaces  
 */
package com.acme.todolist.application.port.in;