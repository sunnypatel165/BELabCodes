.model small
.data
p db 0ffh
q db 0ffh
sum db ?
carry db ?
.code
start:
mov ax,@data
mov ds,ax
mov al,p
mov ah,q
add ah,al
mov sum,ah
mov ax,0000
adc al,00
mov carry,al
end start