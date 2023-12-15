function saltPoints(points, saltMin, saltMax)
  for i=1:length(points)
    if(randi(2)==1)
      points(i,2) = points(i,2) + randi([saltMin, saltMax])
    else
      points(i,2) = points(i,2) - randi([saltMin, saltMax])
    endif
  endfor
endfunction
