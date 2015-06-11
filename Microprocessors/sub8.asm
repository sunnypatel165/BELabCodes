.model small
.data
p db 10h
q db 0ffh
sum db ?
carry db ?
.code
start:
mov ax,@data
mov ds,ax
mov al,p
mov ah,q
sub ah,al
mov sum,ah
mov ax,0000
sbb al,00
mov carry,al
end start