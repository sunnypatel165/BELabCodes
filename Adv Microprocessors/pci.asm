.model small
.data
msg1 db "PCI BIOS present$"
msg2 db "PCI BIOS not present$"

.code
start:
mov ax,@data
mov ds,ax

mov ax,0b10h
int 1ah
mov dx,offset msg2
jnc over
mov dx,offset msg1
over:
	mov ah,09h
	int 21h

mov ah,4ch
int 21h
end start